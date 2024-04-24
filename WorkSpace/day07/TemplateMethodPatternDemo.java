package day07;

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        BeverageRecipe coffee = new Coffee();
        BeverageRecipe tea  = new Tea();
        coffee.prepareRecipe();
        System.out.println("==================");
        tea.prepareRecipe();
    }
}
