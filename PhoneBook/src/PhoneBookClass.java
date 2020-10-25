//Author: Faizan Hussain
public class PhoneBookClass {
    private PersonClass Parent;
    public PhoneBookClass() {
        Parent = null;
    }
    public void add(String name, String number) {
        PersonClass current = Parent;
        PersonClass p = new PersonClass(name, number);
        if (current == null) {
            Parent = p;
        } else {
            while (true) {
                int val = name.compareTo(current.getName());
                if (val < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(p);
                        break;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight(p);
                        break;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }
    public String find(String Name) {
        PersonClass current = Parent;
        while (true) {
            if (current == null || current.getName() == null) {
                return "Person not found";
            } else {
                int a = Name.compareTo(current.getName());
                if (a == 0) {
                    break;
                } else if (a < 0) {
                    current = current.getLeft();
                } else if (a > 0) {
                    current = current.getRight();
                }
            }
        }
        return current.getPhoneNumber();
    }
    public String change(String Name, String Number) {
        PersonClass current = Parent;
        while (true) {
            if (current == null) {
                return "That person not found";
            } else {
                int var = Name.compareTo(current.getName());
                if (var == 0) {
                    break;
                } else if (var < 0) {
                    current = current.getLeft();
                } else if (var > 0) {
                    current = current.getRight();
                }
            }
            current.setName(Name);
            current.setPhoneNumber(Number);
        }
        return current.getName() + " changed their number to " + current.getPhoneNumber();
    }
    public String delete(String Name) {
        PersonClass current = Parent;
        PersonClass temp = null;
        PersonClass temp2 = null;
        boolean isRight = true;
        if (current == null) {
            return "not in this phone book";
        } else {
            while (true) {
                int b = Name.compareTo(current.getName());
                if (b == 0) {
                    break;
                } else if (b < 0) {
                    temp = current;
                    current = current.getLeft();
                    isRight = false;

                } else if (b > 0) {
                    temp = current;
                    current = current.getRight();
                    isRight = true;
                }
            }
            if (current.getLeft() == null && current.getRight() == null) {
                if (current == Parent) {
                    Parent = null;
                } else if (current != Parent) {
                    temp.setLeft(null);
                    temp.setRight(null);
                }
            } else if ((current.getLeft() == null && current.getRight() != null)) {
                if (temp != null) {
                    if (isRight) {
                        temp.setRight(current.getRight());
                    } else {
                        temp.setLeft(current.getRight());
                    }
                } else {
                    Parent = current.getRight();
                }
            } else if ((current.getLeft() != null && current.getRight() == null)) {
                if (temp != null) {
                    if (isRight) {
                        temp.setRight(current.getLeft());
                    } else {
                        temp.setLeft(current.getLeft());
                    }
                } else {
                    Parent = current.getLeft();
                }
            }
            if (current.getLeft() != null && current.getRight() != null) {
                temp2 = current;
                current = current.getRight();
                while (current.getLeft() != null) {
                    current = current.getLeft();
                }
                if (temp == null) {
                    Parent = current;
                } else {
                    temp.setRight(current);
                }
                current.setLeft(temp2.getLeft());
            }
        }
        return Name + "is removed from the phone book";
    }
    public void view() {
        view(Parent);
    }
    private void view(PersonClass current) {
        if (current != null) {
            view(current.getLeft());
            System.out.println(current.getName() + " " + current.getPhoneNumber());
            view(current.getRight());
        }
    }
    public String print() {
        return print(Parent, "");
    }
    private String print(PersonClass current, String str) {
        if (current != null) {
            print(current.getLeft(), str);
            str += current.getName() + " " + current.getPhoneNumber();
            print(current.getRight(), str);
        }
        return str;
    }
}