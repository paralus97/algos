package challengequestions;

import java.util.*;

class CommonEmails {

    // O(N) operation, even though hash table/set access are constant ops.
    public static List<String> commonEmails(List<String> myEmails,
                                            List<String> yourEmails)
    {
        // How do we track common emails across two lists
        // nested for loop search O(n^2)]
        List<String> list = new ArrayList<>(List.of());
//        Map<String, String> yourEmailsMap = new HashMap<>();
//        for (String email : yourEmails)
//            yourEmailsMap.put(email, email);
//
//        for (String email : myEmails) {
//            if (yourEmailsMap.containsKey(email)) {
//                list.add(email);
//            }
//        }

        HashSet<String> myEmailsSet = new HashSet<>(myEmails);
        HashSet<String> yourEmailsSet = new HashSet<>(yourEmails);
        myEmailsSet.forEach((addr) -> {
            if (yourEmailsSet.contains(addr))
                list.add(addr);
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Expected:");
        System.out.println(Arrays.asList(
                "b@b.com",
                "c@c.com"
        ));
        System.out.println("Actual:");
        System.out.println(commonEmails(
                Arrays.asList(
                        "a@a.com",
                        "b@b.com",
                        "c@c.com"
                ),
                Arrays.asList(
                        "d@d.com",
                        "b@b.com",
                        "c@c.com"
                )
        ));
    }
}