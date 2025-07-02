/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */
    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[2 * this.underlying.length];
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    } // method add

    /**
     * method to find the position of an element in the underlying array
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     */
    public int indexOf(String string) {
        int indexFound = -1;
    //go through all the elements unless the end or string is found
    for (int i = 0; i < this.occupancy && indexFound == -1; i++) {
        //check to see the element is not null or equals the string
        if (this.underlying[i] != null && this.underlying[i].equals(string)) {
            indexFound = i; //store the index where it was found 
        }
    }

    return indexFound; //return the index
} // method indexOf

    /** Method to tell if a string exists in the underlying array */
    public boolean contains(String string) {
        boolean found = false;  //start with false (no sting found)
   //go through all the elements unless the end or string is found
    for (int i = 0; i < this.occupancy && !found; i++) {
        //check to see the element is not null or equals the string
        if (this.underlying[i] != null && this.underlying[i].equals(string)) {
            found = true; //if found then it's true 
        }
    }

    return found; //return the found string 
}
    /** Method to count how many times a string appears in the underlying array*/
    public int countOf(String string) {
        int count = 0; // start with zero matches
    //loop through all elements of the array 
    for (int i = 0; i < this.occupancy; i++) {
        //check to see if the element is not null and goes with the string
        if (this.underlying[i] != null && this.underlying[i].equals(string)) {
            count++; //when it matches the count will go up
        }
    }

    return count; //return the new count
}

    /** method to remove items from the underlying array */
    public String remove(int index) {
        // chceck to see if the index is valid (less than 0) if it is return null
        if (index < 0 || index >= this.occupancy) {
            return null;
        
        }
        //store the element for now 
    String removed  = this.underlying[index];
    //moce all the elements after the one taken out to the left 1
    for (int i = index; i < this.occupancy - 1; i++) {
        this.underlying[i] = this.underlying[i+1];
    }
    //get rid of the last element 
    this.underlying[this.occupancy - 1] = null;
    this.occupancy--;  //lessen the count as one element was taken out

    return removed;  //return removed 
    }

    /** overload remove */ 
    public String remove(String string) {
      String removed = null;  //no element has been removed yet

   //go through the array until either the end is reached or an element is removed
    for (int i = 0; i < this.occupancy && removed == null; i++) {
        //check if current element is not null and equals the string
        if (this.underlying[i] != null && this.underlying[i].equals(string)) {
            removed = this.underlying[i]; //store the element 

            // move elements left to fill it in(love left by one spot)
            for (int j = i; j < this.occupancy - 1; j++) {
                this.underlying[j] = this.underlying[j + 1];
            }

            // get rid of the last element 
            this.underlying[this.occupancy - 1] = null;
            this.occupancy--; //lessen the count as one element was taken out
        }
    }

    return removed; //return the removed element 
}
    /** Complete this method */
    public String toString() {
        //check if there is no elements in the array
        if (this.occupancy == 0) {
        return "DynamicArray is empty"; //message saying that the array is empty if it is
    }
//the beginning of the result 
    String result = "[";
//go through and loop through all the elements in the array
    for (int i = 0; i < this.occupancy; i++) {
        result = result + this.underlying[i];  //append the current element to the result string

        if (i < this.occupancy - 1) {//if this is not the last element then append a comma and space 
            result = result + ", ";
        }
    }
     //append the closing bracket 
    result = result + "]";
    return result; //return the result 
}


    }

// class DynamicArray