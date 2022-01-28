package main.com.adventure.player;
import main.com.adventure.world.objects.Tangible;

/**
 * Stores any Tangible item up to the MAX_CAPACITY.
 */
public class Backpack {

    private static final int MAX_CAPACITY = 5;

    private final Tangible[] items = new Tangible[MAX_CAPACITY];

    /**
     * Adds an item to the backpack array only if there's an empty space in the array.
     * @param item - item to add to the backpack array.
     * @return - true if the item is added. Otherwise, false.
     */
    public boolean addItem(Tangible item) {
        //TODO Complete the function
        boolean success = false;
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (items[i] == null) {
                items[i] = item;
                success = true;
                break;
            }
        }

        return success;
    }

    /**
     * Checks each backpack item's name to see if it matches the given name.
     * @param name - the name of the item to search for.
     * @return - the item if it exists. Otherwise, null.
     */
    public Tangible getItem(String name) {
        //TODO Complete the function
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (items[i] != null) {
                if (items[i].getName().equals(name)) {
                    return items[i];
                }
            }
        }
        return null;
    }

    /**
     * Checks if the given item exists in the backpack based on the item's name, and removes the item if it's found.
     * @param item - item to remove
     * @return - true if the item was removed. Otherwise, false.
     */
    public boolean removeItem(Tangible item) {
        boolean success = false;
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (items[i] != null) {
                if (items[i].getName().equals(item.getName())) {
                    items[i] = null;
                    success = true;
                    break;
                }
            }
        }
        return success;
    }

    /**
     * Prints the contents of the backpack. Before printing the contents, the following line should
     * be printed:
     *
     *          "Here are the items in your backpack:"
     *
     * Then each item should be printed with " - " before it.
     */
    public void printItems() {
        //TODO Complete the function
        System.out.println("Here are the items in your backpack:");
        for (Tangible aItem : items) {
            System.out.printf(" - %s", aItem);
        }
    }
}
