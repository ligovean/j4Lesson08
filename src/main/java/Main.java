public class Main {
    public static void main(String[] args) {
        HashTable<ItemDefinition, Integer> hashTable = new LinkedHashTableImpl<>(6);

        ItemDefinition orange = new ItemDefinition(1, "Апельсин");
        ItemDefinition banana = new ItemDefinition(71, "Банан");
        ItemDefinition lemon = new ItemDefinition(60, "Лимон");
        ItemDefinition milk = new ItemDefinition(52, "Молоко");
        ItemDefinition potato = new ItemDefinition(21, "Картофель");
        ItemDefinition avocado = new ItemDefinition(6, "Авокадо");
        //ItemDefinition mango = new ItemDefinition(78, "Манго");


        hashTable.put(orange, 150);
        hashTable.put(banana, 100);
        hashTable.put(lemon, 250);
        hashTable.put(milk, 120);
        hashTable.put(potato, 67);
        hashTable.put(avocado, 67);
        //hashTable.put(mango, 67);

        System.out.println("Size is " + hashTable.size());
        System.out.println("Is Full? " + hashTable.isFull());

        //System.out.println(hashTable.get(banana));
        hashTable.remove(milk);
        hashTable.display();


    }
}

