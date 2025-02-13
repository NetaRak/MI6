package bgu.spl.mics.application.passiveObjects;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



/**
 * Passive data-object representing a information about an agent in MI6.
 * You must not alter any of the given public methods of this class. 
 * <p>
 * You may add ONLY private fields and methods to this class.
 */
public class Squad {

	private Map<String, Agent> agents;
	private static class SingleHolder {
		private static Squad instance = new Squad ();
	}
	private Squad (){
		agents=new HashMap<String, Agent>();
	}
	/**
	 * Retrieves the single instance of this class.
	 */
	public static Squad getInstance() {
		return Squad.SingleHolder.instance;
	}

	/**
	 * Initializes the squad. This method adds all the agents to the squad.
	 * <p>
	 * @param agents Data structure containing all data necessary for initialization
	 * 						of the squad.
	 */
	public void load (Agent[] agents1) {
		for(Agent a:agents1){
			agents.put(a.getSerialNumber(),a);
		}
	}

	/**
	 * Releases agents.
	 */
	public void releaseAgents(List<String> serials){
		for( String agentNum : serials ){
			agents.get(agentNum).release();
		}
	}

	/**
	 * simulates executing a mission by calling sleep.
	 * @param time   milliseconds to sleep
	 */
	public void sendAgents(List<String> serials, int time){
		try {
			Thread.sleep((long) time);
		}catch(InterruptedException exc) {
			exc.printStackTrace();
		}
		releaseAgents(serials);
	}

	/**
	 * acquires an agent, i.e. holds the agent until the caller is done with it
	 * @param serials   the serial numbers of the agents
	 * @return ‘false’ if an agent of serialNumber ‘serial’ is missing, and ‘true’ otherwise
	 */
	public boolean getAgents(List<String> serials){
		for( String agentNum : serials ){
			if (serials.contains(agentNum))
				agents.get(agentNum).acquire();
			else
				return false;
		}
		return true;
	}

    /**
     * gets the agents names
     * @param serials the serial numbers of the agents
     * @return a list of the names of the agents with the specified serials.
     */
    public List<String> getAgentsNames(List<String> serials){
    	List<String> names = new LinkedList<>();
		for( String agentID : serials ){
			names.add(agents.get(agentID).getName());
		}
		return names;
    }

}
