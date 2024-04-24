package day07;

public abstract class BeverageRecipe {
    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
abstract void brew();
    abstract void addCondiments();
    public void boilWater(){
        System.out.println("물을 끓입니다.");
    }
    public void pourInCup(){
        System.out.println("컵에 따릅니다.");
    }
}
