package bgu.spl.mics.application.passiveObjects;

/**
 * Passive data-object representing a information about an agent in MI6.
 * You must not alter any of the given public methods of this class. 
 * <p>
 * You may add ONLY private fields and methods to this class.
 */
public class Agent {
	private String serialNumber;
	private String name;
	private boolean isAve;

	/**
	 * Sets the serial number of an agent.
	 */
	public void setSerialNumber(String _serialNumber) {
		serialNumber=_serialNumber;
	}

	/**
     * Retrieves the serial number of an agent.
     * <p>
     * @return The serial number of an agent.
     */
	public String getSerialNumber() {

		return serialNumber;
	}

	/**
	 * Sets the name of the agent.
	 */
	public void setName(String _name) {
		name=_name;
	}

	/**
     * Retrieves the name of the agent.
     * <p>
     * @return the name of the agent.
     */
	public String getName() {
		return name;
	}

	/**
     * Retrieves if the agent is available.
     * <p>
     * @return if the agent is available.
     */
	public boolean isAvailable() {

		return isAve;
	}

	/**
	 * Acquires an agent.
	 */
	public void acquire(){
		isAve=false;
	}

	/**
	 * Releases an agent.
	 */
	public void release(){
		isAve=true;
	}
}
