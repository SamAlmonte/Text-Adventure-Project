package main.com.adventure.world.objects;

import main.com.adventure.world.objects.keys.Key;

public class Hole {
    /**
     *
     * @ treasure reveals the content of the hole.
     */
    HoleContent treasure;

    /**
     * Creates a hole with the given content.
     * @param content - the item that is covered by the hole.
     */

    public Hole(Key content) {
        treasure = new HoleContent(content);
    }

    public boolean isCovered() {
        //TODO This value should come from HoleContent
        return treasure.isCovered();
    }

    /**
     * Uncovers the hole. If applicable, the contents are now revealed.
     */
    public void dig() {
        //TODO this function should update HoleContent's isCovered property.
        if (treasure.isCovered()) {
            treasure.setIsCovered(false);
        }
    }

    /**
     * If the HoleContent is uncovered, return the key. Otherwise, return null.
     * @return the key if the hold is uncovered.
     */
    private Key getKeyIfPossible() {
        //TODO Get the HoleContent's content only if the hole is uncovered.
        if (!treasure.isCovered()) {
            return getKeyIfPossible();
        }
        return null;
    }

    /**
     * If the HoleContent is uncovered, return the content. Otherwise, return null.
     * @return - the content if the hole is uncovered.
     */
    public Tangible getContent() {
        return getKeyIfPossible();
    }
}
