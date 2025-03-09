public class Mercedes extends  Car implements Vehicle{

    @Override
    public void moveForward() {
        System.out.println("Jedz");
    }

    @Override
    public void printname() {
        //System.out.println("Mercedes")


        throw new MercedesException("Not implemented yet");
    }

}
