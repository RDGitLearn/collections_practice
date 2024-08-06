package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class Main {

    ArrayList<Student> students =null;
    public static void main(String[] args){
            Main m = new Main();
            m.createAL();
        try {
            System.out.println("OP : " + m.isNullOrEmpty(m.students,"java.util.ArrayList","get(0).getSubjects().get(0).getName()" ));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
    public void createAL(){
        students = new ArrayList<>();
        students.add(createStudent());
        students.add(createStudent());
        students.add(createStudent());
        students.add(createStudent());
    }
    public Student createStudent(){
        Student student = new Student();


        student.setName("Rishu");
        student.setSubjects(new ArrayList<Subject>());
        /*student.getSubjects().add(new Subject("Hindi"));
        student.getSubjects().add(new Subject("Eng"));
        student.getSubjects().add(new Subject("Math"));
        student.getSubjects().add(new Subject("History"));*/
        return student;
    }

    public boolean isNullOrEmpty(Object o, String className, String path) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        String[] pathChecks = path.split("\\.");
        var inst = Class.forName(className);
        var objPassed = inst.cast(o);
        Object obj =null;
        if(isEmpty(objPassed)){
            return true;
        }
        for (String p: pathChecks) {
            for (Method m: inst.getMethods()) {
                //System.out.println(m.getName());
                if(p.contains(m.getName())){
                    if(m.getParameters().length==0) {
                        if (isEmpty(m.invoke(objPassed, null))) {
                            return true;
                        } else {
                            objPassed = m.invoke(objPassed, null);
                            inst = Class.forName(objPassed.getClass().getName());
                        }
                    }else{
                        if (isEmpty(m.invoke(objPassed, 0))) {
                            return true;
                        } else {
                            objPassed = m.invoke(objPassed, 0);
                            inst = Class.forName(objPassed.getClass().getName());
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isEmpty(final Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        }
        if (isArray(object)) {
            return Array.getLength(object) == 0;
        }
        if (object instanceof Collection<?>) {
            return ((Collection<?>) object).isEmpty();
        }
        if (object instanceof Map<?, ?>) {
            return ((Map<?, ?>) object).isEmpty();
        }
        if (object instanceof Optional<?>) {
            // TODO Java 11 Use Optional#isEmpty()
            return !((Optional<?>) object).isPresent();
        }
        return false;
    }
    public static boolean isArray(final Object object) {
        return object != null && object.getClass().isArray();
    }




}
