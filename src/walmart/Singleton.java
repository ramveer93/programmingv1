package walmart;

public class Singleton {

	private static Singleton singleton = null;

	private Singleton() {

	}

	/**
	 * Not thread safe
	 * 
	 * @return
	 */
	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	/**
	 * thread sage
	 * 
	 * @return slow performance , multiple threads can not access it
	 */
	public static synchronized Singleton getInstanceThreadSafeSlow() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;

	}

	/**
	 * thread safe and fast
	 * 
	 * two way locking mechanism
	 * 
	 * @return
	 */
	public static Singleton getInstanceThreadSafe() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;

	}

}
