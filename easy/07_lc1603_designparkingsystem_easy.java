class ParkingSystem {
    // Array to store available slots: index 1 = big, 2 = medium, 3 = small
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[] { 0, big, medium, small };
    }
    
    public boolean addCar(int carType) {
        // Check if a slot of the requested carType is available
        if (slots[carType] > 0) {
            slots[carType]--; // Occupy one slot
            return true;
        }
        
        return false; // No space available
    }
}
