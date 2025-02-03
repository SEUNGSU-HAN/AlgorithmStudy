package com.boj.solution.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

//stream으로 변경한 버전
public class Main_2178_Solution2 {
	static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    // 좌표 클래스 추가
    record Point(int r, int c) {
        Point move(int dir) {
            return new Point(r + dr[dir], c + dc[dir]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        // 입력 처리를 Stream으로 변환
        int[] dims = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        N = dims[0];
        M = dims[1];
        
        map = new int[N][M];
        visited = new int[N][M];

        // 맵 입력 처리
        map = br.lines()
               .limit(N)
               .map(line -> line.chars()
                              .map(c -> c - '0')
                              .toArray())
               .toArray(int[][]::new);
        

        // BFS 구현
        Queue<Point> queue = new LinkedList<>();
        Point start = new Point(0, 0);
        queue.offer(start);
        visited[0][0] = 1;

        Predicate<Point> isValid = p -> p.r >= 0 && p.r < N && p.c >= 0 && p.c < M;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            if (current.r == N-1 && current.c == M-1) {
                break;
            }

            // 4방향 탐색을 Stream으로 처리
            Arrays.stream(new int[]{0, 1, 2, 3})
                  .mapToObj(current::move)
                  .filter(isValid)
                  .filter(p -> map[p.r][p.c] == 1 && visited[p.r][p.c] == 0)
                  .forEach(p -> {
                      queue.offer(p);
                      visited[p.r][p.c] = visited[current.r][current.c] + 1;
                  });
        }

        System.out.println(visited[N-1][M-1]);
    }
}