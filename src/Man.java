public class Man {
    private String[] manList  = {"sad", "mad","fat","rich"};

    public void getManFiles(String[] imageList){
        String man = getMan();
        switch (man) {
            case ("sad"):
                imageList[0]= ".//res//sad//sad1.png";
                imageList[1]=".//res//sad//sad2.png";
                imageList[2]=".//res//sad//sad3.png";
                imageList[3]=".//res//sad//sad4.png";
                imageList[4]=".//res//sad//sad5.png";
                imageList[5]=".//res//sad//sad6.png";
                imageList[6]=".//res//sad//sad_dead.png";
                break;
        
            case("mad"):
                imageList[0]= ".//res//mad//mad1.png";
                imageList[1]=".//res//mad//mad2.png";
                imageList[2]=".//res//mad//mad3.png";
                imageList[3]=".//res//mad//mad4.png";
                imageList[4]=".//res//mad//mad5.png";
                imageList[5]=".//res//mad//mad6.png";
                imageList[6]=".//res//mad//mad_dead.png";
                break;
            case("rich"):
                imageList[0]= ".//res//rich//rich1.png";
                imageList[1]=".//res//rich//rich2.png";
                imageList[2]=".//res//rich//rich3.png";
                imageList[3]=".//res//rich//rich4.png";
                imageList[4]=".//res//rich//rich5.png";
                imageList[5]=".//res//rich//rich6.png";
                imageList[6]=".//res//rich//rich_dead.png";
                break;
            case("fat"):
                imageList[0]= ".//res//fat//fat1.png";
                imageList[1]=".//res//fat//fat2.png";
                imageList[2]=".//res//fat//fat3.png";
                imageList[3]=".//res//fat//fat4.png";
                imageList[4]=".//res//fat//fat5.png";
                imageList[5]=".//res//fat//fat6.png";
                imageList[6]=".//res//fat//fat_dead.png";
                break;
        }
        for(int i = 0; i < imageList.length; i++){
            System.out.println(imageList[i]);
        }
       
    }
    public String getMan(){
        int random = (int)(Math.random()*manList.length);
        return manList[random];
    }
}
