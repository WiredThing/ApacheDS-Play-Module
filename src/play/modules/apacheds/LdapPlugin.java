package play.modules.apacheds;

import play.Logger;
import play.PlayPlugin;
import play.Play;



public class LdapPlugin extends PlayPlugin {
	EmbeddedADS ldapServer;
	
	@Override
	public void onApplicationStart() {
		Logger.info("Attempting to start the ldap server");
		        try {
		        	ldapServer = new EmbeddedADS(Play.getFile("../data/"));
		            ldapServer.startServer();
					Logger.info("LDAP server started");
		        } catch (Exception e) {
		            Logger.error(e, "There was an error starting the LDAP server");
		        }
	}
	
	@Override
	public void onApplicationStop() {
		Logger.info("Attempting to stop the LDAP server");
		try {
			ldapServer.stopServer(); 
			Logger.info("LDAP server Stopped");
		} catch (Exception e) {
			Logger.error(e, "There was an error stopping the LDAP Server");
		}
	}
}