package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        // Dummy Data:
        addItem(new TodoItem("First", "First details", LocalDate.now()));
        addItem(new TodoItem("Second", "Second details", LocalDate.now()));
        addItem(new TodoItem("Third", "Third details", LocalDate.now()));
        addItem(new TodoItem("Fourth", "Fourth details", LocalDate.now()));
    }

//    *** READ ***
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }
//    *** CREATE ***
    public void addItem(@NonNull TodoItem toAdd) {
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }
//    *** DELETE ***
    public void removeItem(int id){
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while(itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if(item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
    }
//    *** FIND ITEM ***
    public TodoItem getItem(int id){
        for (TodoItem item : items){
            if(item.getId()== id){
                return item;
            }
        }
        return null;
    }
//    *** UPDATE ***
    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while(itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if(item.equals(toUpdate)){
                itemIterator.set(toUpdate);
                break;
            }
        }
    }
}
