package fr.liglab.adele.cream.utils;

/**
 * Created by aygalinc on 09/09/16.
 */
public interface GeneratedDelegatorProxy {

    public void setPojo(Object pojo);
// mv = cw.visitMethod(ACC_PUBLIC, "setPojo", "(Ljava/lang/Object;)V", null, null);

    public Object getPojo();
// mv = cw.visitMethod(ACC_PUBLIC, "setPojo", "(Ljava/lang/Object;)V", null, null);

    public Object delegate(int methodhashcode,Object[] args) throws Throwable;
    // mv = cw.visitMethod(ACC_PUBLIC, "delegate", "(Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
}