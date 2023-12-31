package org.example.command;

import org.example.collection.CollectionManager;
import org.example.dtp.Request;
import org.example.dtp.Response;
import org.example.dtp.ResponseStatus;
import org.example.error.IllegalArgumentsException;
/**
 * print_unique_melee_weapon :
 * print the unique values of the MeleeWeapon field of all items in the collection
 */
public class PrintUniqueMeleeWeaponCommand extends BaseCommand{
    private final CollectionManager collectionManager;

    public PrintUniqueMeleeWeaponCommand(CollectionManager collectionManager) {
        super("print_unique_melee_weapon", "print_unique_melee_weapon: вывести уникальные значения поля meleeWeapon всех элементов в коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) throws IllegalArgumentsException {
        if (!request.getArgs().isBlank()) throw new IllegalArgumentsException();
        if (CollectionManager.getCollection() == null || CollectionManager.getCollection().isEmpty()) {
            return new Response(ResponseStatus.ERROR, "Коллекция еще не инициализирована");
        }
        return new Response(ResponseStatus.OK, "Уникальные значения поля meleeWeapon: " + collectionManager.printUniqueMeleeWeapon() + "\n");
    }

}
