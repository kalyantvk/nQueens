/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueens;

/**
 *
 * @author rgukt
 */
public class NQueens {

    static int[][] board={
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };
    static  int[] oldpos={-1,-1,-1,-1};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n=4;
        int i=0;
        System.out.println("dfdfd");
        
            
            while(i<4)
            {
                System.out.println("in loop");
                int flag=0;
                
                for(int pos=oldpos[i]+1;pos<4;pos++)
                {
                    System.out.println("i"+i+"pos"+pos);
                    System.out.println("in for");
                    if(isVerticalValid(i,pos) && isDaigonalsValid(i,pos)){
                        System.out.println(i+""+pos);
                        board[i][pos]=1;
                        oldpos[i]=pos;
                        flag=1;
                        break;
                    }
                    
                }
                printBoard();
                if(i>=1 && flag==0)
                {
                    if(oldpos[i]!=-1)
                        oldpos[i]=-1;
                    
                    i--;
                        
                    board[i][oldpos[i]]=0;
                    
                    
                }
                else
                    i++;                    
            }
            printBoard();
            
        
    }
    static void printBoard()
    {
        for(int i=0;i<4;i++)
            {
                for(int j=0;j<4;j++)
                {
                   System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        for(int i=0;i<4;i++)
            System.out.print(oldpos[i]+" ");
    }
    static boolean isVerticalValid(int row,int col)
    {
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][col]==1)
            {
                return false;
            }
        }
        return true;
    }
    static boolean isDaigonalsValid(int x,int y)
    {
        //top rightoldpos[i]=0;
        
            for(int i=x-1,j=y+1;i>=0 && j<4;i--,j++)
            {
                if(board[i][j]==1)
                    return false;
            }
        
        //top left
       
            for(int i=x-1,j=y-1;i>=0 && j>=0 ;i--,j--)
            {
                if(board[i][j]==1)
                    return false;
                
            }
        
        
        return true;
    }
    static boolean isFilled()
    {
        for(int i=0;i<4;i++)
        {
            int flag=0;
            for(int j=0;j<4;j++)
            {
                if(board[i][j]==1)
                    flag=1;
                    
            }
            if(flag==0)
                return false;
        }
        return true;
    }
    
}
