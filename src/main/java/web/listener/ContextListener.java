package web.listener;

import sql.SQLHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        initDataTable();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void initDataTable() {
        SQLHandler sqlHandler = new SQLHandler();
        sqlHandler.openConnection();
        sqlHandler.initTable();
        sqlHandler.closeConnection();
    }
}
