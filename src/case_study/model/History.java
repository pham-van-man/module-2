package case_study.model;

import case_study.ulti.Handler;

import java.util.Map;

public class History {
    private static final String PATH = "src/case_study/data/history.ser";

    public static Map<Account, String> findAll(Handler historyHandler) {
        return historyHandler.readerObject(PATH);
    }

    public static void writer(Account account, String history, Handler historyHandler) {
        Map<Account, String> listHistory = findAll(historyHandler);
        if (listHistory == null) {
            return;
        }
        if (listHistory.containsKey(account)) {
            listHistory.put(account, history + listHistory.get(account));
        } else {
            listHistory.put(account, history);
        }
        historyHandler.writerObject(listHistory, PATH);
    }

    public static String read(Account account, Handler historyHandler) {
        Map<Account, String> listHistory = findAll(historyHandler);
        if (listHistory == null) {
            return null;
        }
        return listHistory.get(account);
    }
}
