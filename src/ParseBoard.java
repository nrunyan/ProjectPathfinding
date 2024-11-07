import java.util.ArrayList;
import java.util.List;

public class ParseBoard {
    private List<List<Integer>> adjecency=new ArrayList<>();
    private int amountOfNodes;
    private int colunmSize;
    private int rowSize;
    private final char emptySpace='.';
    private final char items='x';
    private final char obsticles='#';
    public ParseBoard(char[][] board, int amountOfNodes, int colunmSize, int rowSize){
        this.amountOfNodes=amountOfNodes;
        this.colunmSize=colunmSize;
        this.rowSize=rowSize;
    }
    private void createAdjecencyList(char [][] board){
        for(int i=0;i<amountOfNodes;i++){
            adjecency.add(new ArrayList<>());
        }
        for(int row=0;row<colunmSize;row++){
            for(int colm=0;colm<colunmSize;colm++){
                int n=row*colunmSize+colm;
                System.out.println(n);
                List<Integer> neighbors=findNeighbors(board,n);
                adjecency.get(n).addAll(neighbors);

            }
        }
        adjecency.get(0).add(3);
        adjecency.get(0).add(1);
        adjecency.get(0).add(2);
        adjecency.get(1).add(3);
        adjecency.get(2).add(0);
        adjecency.get(2).add(1);
        int start = 2, dst = 3;
        System.out.println("path from src " + start +
                " to dst " + dst + " are ");

        // Function for finding the paths
        BreadFirst.findPaths(adjecency, start, dst);
    }
    private List<Integer> findNeighbors(char [][] board, int n){

        return null;
    }
}
