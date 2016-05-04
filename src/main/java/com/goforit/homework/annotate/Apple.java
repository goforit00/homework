package com.goforit.homework.annotate;


import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by junqingfjq on 16/5/4.
 */
public class Apple {

    @FruitName
    private String appleName;

    @FruitColor
    private String appleColor;


    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "appleName='" + appleName + '\'' +
                ", appleColor='" + appleColor + '\'' +
                '}';
    }
    

    public static void main(String argv[]){

        try {
            Field [] fields= Apple.class.getDeclaredFields();
            Apple app=new Apple();
            System.err.println(app);

            String annColorFieldName="fruitColor";
            String annNameFieldName="value";
            Map<String, Object> colorMap = AnnotationUtil.INSTANCE.loadFieldAnnotationValues(
                FruitColor.class, annColorFieldName,
                "com.goforit.homework.annotate.Apple");

            Map<String, Object> nameMap = AnnotationUtil.INSTANCE.loadFieldAnnotationValues(
                    FruitName.class, annNameFieldName,
                    "com.goforit.homework.annotate.Apple");


            for(Field field:fields){
                Object color=colorMap.get(field.getName());
                if(null!=color){
                    field.set(app,color.toString());
                    continue;
                }

                Object name=nameMap.get(field.getName());
                if(null!=name){
                    field.set(app,name.toString());
                    continue;
                }
            }




            System.err.println(app);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


