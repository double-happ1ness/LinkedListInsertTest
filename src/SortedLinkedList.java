// this is a cut down version of the class specifically for the Insert test
// the complete version is in the Library folder on Moodle

public class SortedLinkedList implements SortedADT {

    private class ListNode {

        private Comparable object;
        private ListNode next;
    }
    private ListNode head;

    public String toString() {
        /* algorithm
            set up a string to contain the list details
            if list not empty then
                set current node to head of list
                while nodes remain loop
                    add the node object to the string
                    move to next node
                end loop
            else
                add empty list message to the string
         end if
         */
        String listDetails = new String();
        if (this.head != null) {
            ListNode current = this.head;
            while (current != null) {
                listDetails += current.object + "\n";
                current = current.next;
            }
        } else {
            listDetails += "list is empty";
        }
        return listDetails;
    }

    public void insert(Comparable object) throws NotUniqueException {
        /* algorithm		
            create a new node //will create component object reference
            if list empty then
                add to head of list
            else
                set current node to head of list
                while insertion position not yet found loop
                    if object to be added matches current object then
                        // attempt to add duplicate object
                        throw not unique exception
                    end if
                    if object to be added is less than current object then
                        link the new node to the current node
                        if current node is the head then
                            // add to the front of the list
                            link the head to the new node
                        else
                            link the previous node to the new node
                        end if
                    else
                        if current node is the last in the list
                            // add at end
                            link the current node to the new node
                        else
                            // move to the next node
                            set the previous node as the current node
                            set the current node to the next node
                        end if
                    end if
                end loop
            end if				
         */
        ListNode newNode = new ListNode();
        newNode.object = object;
        if (this.head == null) {
            this.head = newNode;
        } else {
            ListNode current = this.head;
            // require to explicitly set to null to avoid compilation error
            ListNode previous = null;
            Boolean insertionPositionFound = false;
            while (!insertionPositionFound) {
                if (object.compareTo(current.object) == 0) {
                    throw new NotUniqueException();
                }
                // add code here
                if (object.compareTo(current.object) < 0) {
                    insertionPositionFound = true;
                    newNode.next = current;
                    if (current == this.head) {
                        this.head = newNode;
                    } else {
                        previous.next = newNode;
                        insertionPositionFound = true;
                    }
                } else {
                    if (current.next == null) {
                        insertionPositionFound = true;
                        current.next = newNode;
                    } else {
                        previous = current;
                        current = current.next;
                    }
                }
            }
        }
    }
}
