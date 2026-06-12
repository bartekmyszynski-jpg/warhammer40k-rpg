public class Narracja {
    public static void opisWroga(Wrog wrog) {
        System.out.println("\n++ KONTAK Z WROGIEM ++");
        switch (wrog.getFrakcja()) {
            case CHAOS:
                System.out.println("Mroczna energia Chaosu wypełnia powietrze.");
                System.out.println("Przed Tobą staje " + wrog.getImie() + " - sługa Czterech Bogów Ciemności");
                System.out.println("W jego oczach płonie szaleństwo");
                break;
            case NEKRONI:
                System.out.println("Metaliczny zgrzyt wypełnia ciszę.");
                System.out.println(wrog.getImie() + " wyłania się z ciemności - nieśmiertelny i bezlitosny");
                System.out.println("Zielone oczy świecą zimnym, starożytnym światłem");
                break;
            case IMPERIUM:
                System.out.println("Brat staje przeciwko bratu.");
                System.out.println(wrog.getImie() + " zdradził Imperatora - jego dusza jest stracona");
                break;
            default:
                System.out.println("Nieznany wróg staje na Twojej drodze.");
                break;
        }
        System.out.println("Za imperatora!");
    }

    public static void opisZwyciestwa(Bohater bohater, Wrog wrog) {
        System.out.println("\n++ ZWYCIĘSTWO ++");
        switch (wrog.getFrakcja()) {
            case CHAOS:
                System.out.println(wrog.getImie() + " pada u Twoich stóp. Chaos traci kolejnego sługę.");
                System.out.println("Imperator patrzy na Ciebie z aprobatą " + bohater.getImie() + ".");
                break;
            case NEKRONI:
                System.out.println("Metaliczne ciało " + wrog.getImie() + " rozpada się na atomy.");
                break;
            case IMPERIUM:
                System.out.println("Heretyk nie żyje.. Tak kończy każdy zdrajca.");
                System.out.println("Nie ma miejsca na litość dla wrogów Imperatora.");
                break;
            default:
                System.out.println("Honor: " + bohater.getHonor() + " | EXP: " + bohater.getExp() + "\n");
        }
    }

    public static void opisPorazki(Bohater bohater, Wrog wrog) {
        System.out.println("\n++ SPACE MARINE DOWN ++");
        System.out.println("Brother " + bohater.getImie() +
                " pada na ziemię Tartarus IV.");
        System.out.println("Krew Space Marine zasila tę przeklętą planetę.");
        switch (wrog.getFrakcja()) {
            case CHAOS:
                System.out.println("Chaos pochłania kolejną duszę...");
                break;
            case NEKRONI:
                System.out.println("Czujesz jak działko plazmowe rozkłada Twoje ciało na atomy.");
                break;
            case IMPERIUM:
                System.out.println("Zawiodłeś swój zakon. Ostrze Heretyka przebija Twoje serce.");
                break;
        }
        System.out.println("\nTartarus IV jest stracona.");
        System.out.println("Niech Imperator przyjmie twą duszę.\n");
        System.out.println("★ GAME OVER ★");
    }
}
