package dao;

import dao.exception.KeyNotTrueException;
import dao.exception.ProfileNotFoundException;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DaoMock {
    private static final DaoMock daoMock = new DaoMock();

    private Map<String, Profile> accountMap = new ConcurrentHashMap<>();
    private Map<String, String> sessionMap = new ConcurrentHashMap<>();

    private DaoMock() {
    }

    public static DaoMock getInstance() {
        return daoMock;
    }

    public void addNewProfile(Profile profile) {
        accountMap.put(profile.getLogin(), profile);
    }

    public Set<String> keysProfile() {
        return accountMap.keySet();
    }

    public void addOnlineSession(String id, String login) {
        sessionMap.put(id, login);
    }

    public void containProfile(String login, String pass) throws KeyNotTrueException, ProfileNotFoundException {
        Profile profile = accountMap.get(login);

        if (profile == null) {
            throw new ProfileNotFoundException("Логин не найден");
        }
        if (!profile.getPass().equals(pass)) {
            throw new KeyNotTrueException("Неверный логин или пароль");
        }
    }
}
