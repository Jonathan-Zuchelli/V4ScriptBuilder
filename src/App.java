import javax.swing.JFrame;

public class App {

    private View mView;

    public static void main(String[] args){
        new App().Run();
    }
    public void Run(){
        JFrame.setDefaultLookAndFeelDecorated(false);
        setView(new View(this));
    }
    public void exit(){
        System.exit(0);
    }
    private View getView(){
        return mView;
    }
    private void setView(View pView){
        mView = pView;
    }
}
