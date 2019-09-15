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
import java.util.*;
import java.io.*;
public class nQueensAll {
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    solveNQueens snq=new solveNQueens();
    snq.solveBoard(n);
    }

    
    
    
    
}
class solveNQueens{
    
    
    static int[][] board;
    static int[] oldpos;
    
    public solveNQueens() {
        
        
    }
    static void solveBoard(int n){
        
        
        int i=0;
        board=new int[n][n];
        for(int ind=0;ind<n;ind++)
            for(int j=0;j<n;j++)
                board[ind][j]=0;
        int[] oldpos=new int[n];
        for(int ind=0;ind<n;ind++)
            oldpos[ind]=-1;
        while(i<n)
        {
                int flag=0;
                
                for(int pos=oldpos[i]+1;pos<n;pos++)
                {
                    
                    if(isVerticalValid(i,pos) && isDaigonalsValid(i,pos,n)){
                        board[i][pos]=1;
                        oldpos[i]=pos;
                        flag=1;
                        break;
                    }
                    
                }
                //printBoard(n);
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
            printBoard(n);
            
        
    }
    static void printBoard(int n)
    {
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                   System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        
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
    static boolean isDaigonalsValid(int x,int y,int n)
    {
        //top rightoldpos[i]=0;
        
            for(int i=x-1,j=y+1;i>=0 && j<n;i--,j++)
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
    
}
