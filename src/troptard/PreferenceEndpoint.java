package troptard;

import troptard.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "preferenceendpoint",
version = "v1",
clientIds = { "35153983746-qfc2aiofclbl9id96m3qoqq6ibesqc49.apps.googleusercontent.com"})
public class PreferenceEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listPreference")
	public CollectionResponse<Preference> listPreference(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Preference> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Preference.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Preference>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Preference obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Preference> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getPreference")
	public Preference getPreference(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		Preference preference = null;
		try {
			preference = mgr.getObjectById(Preference.class, id);
		} finally {
			mgr.close();
		}
		return preference;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param preference the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertPreference")
	public Preference insertPreference(Preference preference) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsPreference(preference)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(preference);
		} finally {
			mgr.close();
		}
		return preference;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param preference the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updatePreference")
	public Preference updatePreference(Preference preference) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsPreference(preference)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(preference);
		} finally {
			mgr.close();
		}
		return preference;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removePreference")
	public void removePreference(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Preference preference = mgr.getObjectById(Preference.class, id);
			mgr.deletePersistent(preference);
		} finally {
			mgr.close();
		}
	}

	private boolean containsPreference(Preference preference) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Preference.class, preference.getKey());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
