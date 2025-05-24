import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;
// tes

public class UI_Test2 {
    public static void main(String[] args) {
        LogInRegister();
    }
    public static void LogInRegister(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Register [1]\nLogin [2]");
        int choose = sc.nextInt();
        if (choose==1) {
            Register();
        }
        if (choose==2) {
            Login();
        }
    }
    public static void Register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Register as Public [1]\nRegister as Creator [2]\nBack [3]");
        int choose = sc.nextInt();
        if (choose==1) {
            RegisterPublic();
        }
        if (choose==2) {
            RegisterCreator();
        }
        if (choose==3) {
            Register();
        }
    }
    public static void Login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("LOGIN");
        System.out.print("Username : ");
        String un = sc.next();
        System.out.print("Password : ");
        String pass = sc.next();
        if (pass.equals("admin123")) {
            if (un.equals("public")) {
                Public pa = new Public(un);
                pa.showHome();
            }
            if (un.equals("creator")) {
                Creator cr = new Creator(un);
                cr.creatorHome();
            }
        }
        else{
            System.out.println("Password salah !");
            Login();
        }
    }
    public static void RegisterPublic(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.print("Email : ");
        String email = sc.next();
        System.out.print("Password : ");
        String password = sc.next();
        System.out.print("Confirm Password : ");
        String cPassword = sc.next();
        if (!cPassword.equals(password)) {
            RegisterPublic();
        }
        else{
            PublicAccount();
        }
    }
    public static void RegisterCreator(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Email : ");
        String email = sc.next();
        System.out.print("Password : ");
        String password = sc.next();
        System.out.print("Confirm Password : ");
        String cPassword = sc.next();
        if (!cPassword.equals(password)) {
            RegisterCreator();
        }
        else{
            CreatorAccount();
        }
    }
    public static void PublicAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.print("Username :");
        String username = sc.next();
        Public newPublic = new Public(username);
        newPublic.showHomeNew();
    }
    public static void CreatorAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.print("Channel Name :");
        String username = sc.next();
        Creator newCreator= new Creator(username);
        newCreator.newCreatorHome();
    }
}

class Public {
    String username;

    public Public(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public void showHomeNew(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println(getUsername());
        System.out.println("Liked Video [1]\nSubscribed Channel List [2]");
        System.out.println("BERANDA\nVideo 1 [3]\nVideo 2 [4]\nVideo 3 [5]");
        int choose = sc.nextInt();
        if (choose==1) {
            showLikedVideo(1);
        }
        if (choose==2) {
            showSubscribedChannel(1);
        }
        if (choose==3) {
            showVideoChoosedFromPublic(1,1);
        }
        if (choose==4) {
            showVideoChoosedFromPublic(2,1);
        }
        if (choose==3) {
            showVideoChoosedFromPublic(3,1);
        }
    }
    public void showHome(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println(getUsername());
        System.out.println("Liked Video [1]\nSubscribed Channel List [2]");
        int choose = sc.nextInt();
        if (choose==1) {
            showLikedVideo(2);
        }
        if (choose==2) {
            showSubscribedChannel(2);
        }
    }
    public void showLikedVideo(int status){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        if (status==1) {//Untuk pengguna baru
            System.out.println("Liked Videos List :");
            System.out.println("List is empty");
            System.out.println("Back [0]");
            int choose = sc.nextInt();
            showHomeNew();
        }
        if (status==2) {//Untuk pengguna terdaftar
            System.out.println("Liked Videos List");
            System.out.println("Video 1 [1]");
            System.out.println("Video 2 [2]");
            System.out.println("Video 3 [3]");
            System.out.println("Back [0]");
            int choose = sc.nextInt();
            if (choose==1||choose==2||choose==3) {
                showVideoChoosedFromPublic(choose,2);
            }
            if (choose==0) {
                showHome();    
            }
        }
    }
    public void showSubscribedChannel(int status){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        if (status==1) {
            System.out.println("Subscribed Channel :");
            System.out.println("List is empty");
            System.out.println("Back [0]");
            int choose = sc.nextInt();
            showHomeNew();
        }
        if (status==2) {
            System.out.println("Subscribed Channel :");
            System.out.println("Channel 1 [1]\nChannel 2 [2]\nChannel 3 [3]\nBack [0]");
            int choose = sc.nextInt();
            if (choose==1||choose==2||choose==3) {
                showChannelFromPublic(choose);
            }
            if (choose==0) {
                showHome();
            }
        }
    }
    public void showVideoChoosedFromPublic(int i, int from){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        if (i==1) {
            System.out.println("Video 1 is playing...");
            System.out.println("Like : 99");
            System.out.println("Channel 1");
            System.out.println("Back [0]");
            int input = sc.nextInt();
            if (from==1) {
                showHomeNew();
            }
            if (from==2) {
                showLikedVideo(2);
            }
        }
        if (i==2) {
            System.out.println("Video 2 is playing...");
            System.out.println("Like : 999");
            System.out.println("Channel 2");
            System.out.println("Back [0]");
            int input = sc.nextInt();
            if (from==1) {
                showHomeNew();
            }
            if (from==2) {
                showLikedVideo(2);
            }
        }
        if (i==3) {
            System.out.println("Video 3 is playing...");
            System.out.println("Like : 9999");
            System.out.println("Channel 3");
            System.out.println("Back [0]");
            int input = sc.nextInt();
            if (from==1) {
                showHomeNew();
            }
            if (from==2) {
                showLikedVideo(2);
            }
        }
    }
    public void showChannelFromPublic(int i){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        if (i==1) {
            System.out.println("Channel 1");
            System.out.println("Subscriber : 100");
            System.out.println("Video 1");
            System.out.println("Back [0]");
            int input = sc.nextInt();
            showSubscribedChannel(2);
        }
        if (i==1) {
            System.out.println("Channel 2");
            System.out.println("Subscriber : 1000");
            System.out.println("Video 1");
            System.out.println("Back [0]");
            int input = sc.nextInt();
            showSubscribedChannel(2);
        }
        if (i==1) {
            System.out.println("Channel 3");
            System.out.println("Subscriber : 10000");
            System.out.println("Video 1");
            System.out.println("Back [0]");
            int input = sc.nextInt();
            showSubscribedChannel(2);
        }
    }
    
}

class Creator{
    String channelName;

    public Creator(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void newCreatorHome(){
        System.out.println("--------------------");
        System.out.println(getChannelName());
        System.out.println("Subscriber : 0");
        System.out.println("Total Like : 0");
        System.out.println("--No Videos Uploaded--");
    }

    public void creatorHome(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println(getChannelName());
        System.out.println("Subscriber : 100");
        System.out.println("Total Like : 650");
        System.out.println("Group Channel [1]");
        System.out.println("Video 1 [2]\nVideo 2 [3]");
        int choose = sc.nextInt();
        if (choose==1) {
            GroupChannelList();
        }
        if (choose==2) {
            showVideoFromCreator(1);
        }
        if (choose==3) {
            showVideoFromCreator(2);
        }
    }
    public void GroupChannelList(){
        System.out.println("--------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Group 1 [1]\nBack [0]");
        int choose = sc.nextInt();
        if (choose==1) {
            showGroup(choose);
        }
        if (choose==0) {
            creatorHome();
        }
    }
    public void showGroup(int choose){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        if (choose==1) {
            System.out.println("Group 1");
            System.out.println("Role : Manajer");
            System.out.println("Back [0]");
            int chooses = sc.nextInt();
            if (chooses==0) {
                GroupChannelList();
            }
        }
    }
    public void showVideoFromCreator(int i){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        if (i==1) {

            System.out.println("Video 1 is playing...");
            System.out.println("Like : 99");
            System.out.println("Channel : " + getChannelName());
            System.out.println("Back [0]");
            int input = sc.nextInt();
            creatorHome();
        }
        if (i==2) {
            System.out.println("Video 2 is playing...");
            System.out.println("Like : 999");
            System.out.println("Channel : " + getChannelName());
            System.out.println("Back [0]");
            int input = sc.nextInt();
            creatorHome(); 
        }
    }
}
