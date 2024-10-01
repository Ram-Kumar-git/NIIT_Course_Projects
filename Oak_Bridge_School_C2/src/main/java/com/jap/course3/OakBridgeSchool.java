package com.jap.course3;

public class OakBridgeSchool {

    public int[] calculateTotalMarks(int [] math,int science[],int[] english) {
        if(math.length>0 && science.length>0 && english.length>0){
            int totalMarks[] =  new int[math.length];
            for(int i=0;i<math.length;i++){
                totalMarks[i]=math[i]+science[i]+english[i];
            }return totalMarks;
        }
        else{
            return new int[0];
        }
    }
    public int[] calculateTotalAverageMarksForEachStudent(int [] totalMarks, int noOfSubjects){
        if(noOfSubjects>0 && totalMarks.length>0){
            int averageMark[]=new int[totalMarks.length];
            for(int i=0;i<totalMarks.length;i++){
                averageMark[i]= totalMarks[i]/noOfSubjects;
            }return averageMark;
        }
        else{
            return new int[0];
        }

    }
    public double calculateAverageScienceMarks (int[] science,int len)
    {
        if(len==0){
            return 0.0;
        }
        double tsci =0;
        for(int sum : science){
            tsci = tsci + sum; //updates values from science[]
        }
        return(tsci/len);

    }
    public double calculateAverageEnglishMarks(int[] english, int len)
    {
        if(len==0){
            return 0.0;
        }
        double teng =0;
        for(int sum : english){//enhanced loop
            teng = teng + sum;//updates values from english[]
        }
        return(teng/len);
    }
    public double calculateAverageMathMarks (int[] math,int len)
    {
        if(len==0){
            return 0.0;
        }
        double tmath =0;
        for(int sum : math){//enhanced loop
            tmath = tmath + sum;//updates values from math[]
        }
        return(tmath/len);
    }
    // Write the logic inside the method to calculate the grade based on the math mark of the student
    public char findGradeInMath(int math){
        if(math>=90){
            return 'A';
        }
        else if(math>=80){
            return 'B';
        }
        else if(math>=70){
            return 'C';
        }
        else if(math>=60){
            return 'D';
        }
        else{
            return 'F';
        }
    }
    // Write the logic inside the method to calculate the grade based on the science mark of the student
    public char findGradeInScience(int science){
        if(science>=90){
            return 'A';
        }
        else if(science>=80){
            return 'B';
        }
        else if(science>=70){
            return 'C';
        }
        else if(science>=60){
            return 'D';
        }
        else{
            return 'F';
        }
    }
    // Write the logic inside the method to calculate the grade based on the english mark of the student
    public char findGradeInEnglish(int english){
        if(english>=90){
            return 'A';
        }
        else if(english>=80){
            return 'B';
        }
        else if(english>=70){
            return 'C';
        }
        else if(english>=60){
            return 'D';
        }
        else{
            return 'F';
        }
    }
    // Write the logic to sort the total marks of the students of the class in ascending order, use insertion-sort
    public int[] sortByTotalMarks(int[] totalMarks){
        int j=0;int key;
        for (int i = 1; i < totalMarks.length; i++) {
            key = totalMarks[i];
            j = i - 1;
            while (j >= 0 && totalMarks[j] > key) {
                totalMarks[j + 1] = totalMarks[j];
                j--;
            }
            totalMarks[j + 1] = key;
        }
        return totalMarks;
    }
    // Check if any of the studentNames in the array is repeated, if yes return true else false
    public boolean checkIfNamesAreRepeated(String[] studentNames) {
        for(int i=0;i<studentNames.length;i++){
            for(int j=i+1;j<studentNames.length;j++){
                if(studentNames[i].equals(studentNames[j])){
                    return true;
                }

            }
        }return false;
    }
    //write the logic to find the top score using recursion
    public int findTopScore(int [] totalMarks,int len){

        if (len <= 0 || len > totalMarks.length){
            return 0; //This check is for if any array or string beyond or short to the length
        }
        else if (len == 1) {
            return totalMarks[0];
        }
        else {
            int max = findTopScore(totalMarks, len - 1);
            return Math.max(max, totalMarks[len - 1]);
        }
    }
    //Display the details of the student
    public void displayDetails(int totalMark, int averageMark, char mathGrade, char scienceGrade, char englishGrade,String studentName, int rollNo ){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Student Name  ::  "+studentName+"   ||  Roll Number  ::  "+rollNo);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The Total Marks   - "+totalMark+"/300");
        System.out.println("The Average Marks - "+averageMark);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Grading and Evaluation");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Student Name                           Roll Number");
        System.out.println(studentName+"                                  "+rollNo);
        System.out.println("The total marks scored      : "+totalMark);
        System.out.println("The average marks scored    : "+averageMark);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Grade in Math       :"+mathGrade);
        System.out.println("Grade in Science    :"+scienceGrade);
        System.out.println("Grade in English    :"+englishGrade);
        System.out.println("-----------------------------------------------------------------");


    }

    //write the logic to generate the result message using name and score
    public StringBuilder[] generateResultMesssage(String[] studentName,int[] totalScore)
    {
        StringBuilder Result[] = new StringBuilder[studentName.length];
        for(int i = 0; i < studentName.length;i++)
        {
            Result[i] = new StringBuilder("Hi "+studentName[i]+" you have secured "+totalScore[i]);
        }
        return Result;
    }
    public static void main(String[] args){
        OakBridgeSchool obs = new OakBridgeSchool(); //creating instance for the class
        int math[]={88,89,100,70,60,80,35,3,25,56};
        int science[]={80,83,99,67,56,84,38,9,32,65};
        int english[]={90,98,100,65,54,82,40,13,45,67};
        String studentName[]={"Michelle","Kate","Ann","Tina","Tom","Sam","Ria","Pam","Leena","Leo"};
        int rollnos[]={102,109,101,103,104,108,110,105,106,107};
        char mathg[]=new char[studentName.length];
        char scig[]=new char[studentName.length];
        char engg[]=new char[studentName.length];
        int tmarks[]= obs.calculateTotalMarks(math,science,english);
        int amarks[]= obs.calculateTotalAverageMarksForEachStudent(tmarks,3);//3subjects do length is 3
        for(int i=0;i<studentName.length;i++){
            mathg[i]=obs.findGradeInMath(math[i]);
            scig[i]=obs.findGradeInScience(science[i]);
            engg[i]=obs.findGradeInEnglish(english[i]);
        }
        for(int i=0;i<studentName.length;i++){
            obs.displayDetails(tmarks[i], amarks[i], mathg[i], scig[i], engg[i], studentName[i], rollnos[i]);
        }

        boolean namecheck = obs.checkIfNamesAreRepeated(studentName);
        if(namecheck==true){
            System.out.println("Name are repeated...");
        }
        else {
            System.out.println("Names are not repeated...");
        }

        StringBuilder finalresult[] = obs.generateResultMesssage(studentName,tmarks);
        for(int i=0;i<math.length;i++){
            System.out.println(finalresult[i]);
        }
        int sortedarray[]= obs.sortByTotalMarks(tmarks);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Report");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Total Scores in order");
        for(int top : sortedarray){
            System.out.println(top);
        }
        int tscore = obs.findTopScore(tmarks,studentName.length);
        System.out.println("The Top score is : "+tscore);// top score of 9th grade

    }
}
