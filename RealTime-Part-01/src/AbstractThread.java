public abstract class AbstractThread {

    /**
     * Boolean flag that determines whether the thread is active or not
     */
    private boolean active;

    /**
     * The thread
     */
    private Thread thread = new Thread() {
        @Override
        public void run() {
            AbstractThread.this.run();
        }
    };

    /**
     * Abstract run method that determines what will
     * happen when the thread is started
     */
    protected abstract void run();

    /**
     * Starts the thread
     */
    public void start() {
        thread.start();
        active = true;
    }

    /**
     * Stops the thread
     */
    public void stop() {
        thread.interrupt();
        active = false;
    }

    /**
     * Sleeps the thread for the specified amount of time
     *
     * @param milliseconds
     */
    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets whether the thread is active or not
     *
     * @return
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets whether the thread is active or not
     *
     * @param active
     */
    protected void setActive(boolean active) {
        this.active = active;
    }
}
