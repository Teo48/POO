import java.util.*;

public class Main {

    public static void main(String [] args){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(0, "Popescu", "Gigel", 3F));
        students.add(new Student(5, "Popescu", "Ionel", 10F));
        students.add(new Student(3, "Aopescu", "Figel", 8.5F));
        students.add(new Student(2, "Zopescu", "Zonel", 3F));
        students.add(new Student(1, "Bopescu", "Zigel", 8.5F));
        Collections.sort(students);

        for(Student s : students) {
            System.out.println(s);
        }

        PriorityQueue<Student> priorityQueue= new PriorityQueue<>((final Student s1, final Student
                s2) -> Long.compare(s1.getId(), s2.getId()));

        priorityQueue.addAll(students);
        System.out.println("------------------------------------------------");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        HashMap<Student, LinkedList<String>> studentHashMap = new HashMap<>();
        LinkedList<String> subjects = new LinkedList<>();
        subjects.add("Mate");
        subjects.add("Fizica");
        subjects.add("Romana");

        for(Student s : students) {
            studentHashMap.put(s, subjects);
        }

        System.out.println("---------------------------------------------------------");

        for (Map.Entry<Student, LinkedList<String>> entry : studentHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        ModifiedLinkedHashSet<Integer> linkedHashSet = new ModifiedLinkedHashSet();
        LinkedList<Integer> evenIntegerList = new LinkedList<>();
        for (int i = 0 ; i < 10 ; ++i) {
            linkedHashSet.add(i);
            evenIntegerList.add(i);
        }

        Iterator<Integer> it = linkedHashSet.iterator();

        System.out.println("------------------------------------------------");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        linkedHashSet.clear();
        linkedHashSet.addAll(evenIntegerList);

        Iterator<Integer> itt = linkedHashSet.iterator();
        System.out.println("------------------------------------------------");
        while (itt.hasNext()) {
            System.out.println(itt.next());
        }

    }
}
