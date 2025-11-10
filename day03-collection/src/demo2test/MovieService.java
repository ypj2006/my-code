package demo2test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private static List<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public void start() {
        while (true) {
            System.out.println("========电影信息管理系统========");
            System.out.println("1. 上架");
            System.out.println("2. 下架某个电影");
            System.out.println("3. 查询某个电影");
            System.out.println("4. 封杀某个明星的电影");
            System.out.println("5. 退出");
            System.out.println("6. 显示所有电影");
            System.out.println("7. 修改某个电影信息");
            System.out.println("请您输入操作命令：");
            String command = sc.next();
            switch (command) {
                case "1":
                    addMovie();
                    break;
                case "2":
                    removeMovie();
                    break;
                case "3":
                    queryMovie();
                    break;
                case "4":
                    killMovie();
                    break;
                case "5":
                    System.out.println("退出成功");
                    return;
                case "6":
                    showMovies();
                    break;
                case "7":
                    updateMovie();
                    break;
                default:
                    System.out.println("输入有误！");
            }
        }
    }

    private void updateMovie() {
        System.out.println("=======修改电影信息=======");
        System.out.println("请输入电影名称：");
        String name = sc.next();
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            System.out.println("1.修改电影名称");
            System.out.println("2.修改电影主演");
            System.out.println("3.修改电影价格");
            System.out.println("4.修改电影评分");
            System.out.println("请您输入操作命令：");
            String command = sc.next();
            switch (command) {
                case "1": //把集合中对应电影的名称进行修改
                    System.out.println("请输入新的电影名称：");
                    movie.setName(sc.next());
                    System.out.println("修改成功！");
                    break;
                case "2":
                    System.out.println("请输入新的主演名称：");
                    movie.setActor(sc.next());
                    System.out.println("修改成功！");
                    break;
                case "3":
                    System.out.println("请输入新的电影价格：");
                    movie.setPrice(sc.nextDouble());
                    System.out.println("修改成功！");
                    break;
                case "4":
                    System.out.println("请输入新的电影评分：");
                    movie.setScore(sc.nextDouble());
                    System.out.println("修改成功！");
            }
        }
        showMovies();
    }

    private void showMovies() {
        System.out.println("=======所有电影=======");
        for (Movie movie : movies) {
            System.out.println(movie.getName()+ " "+movie.getActor()+ " "+movie.getScore()+ " "+movie.getPrice());
        }
    }

    private void killMovie() {
        System.out.println("=======封杀电影=======");
        System.out.println("请输入明星名称：");
        String actor = sc.next();
        for(int i = 0; i < movies.size(); i++){
            Movie movie = movies.get(i);
            if (movie.getActor().contains(actor)){
                movies.remove(movie);
            }
            System.out.println("封杀成功！");
            i--;
        }
        showMovies();
    }

    private void queryMovie() {
        System.out.println("=======查询电影=======");
        System.out.println("请输入电影名称：");
        String name = sc.next();
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            System.out.println(movie.getName()+ " "+movie.getActor()+ " "+movie.getScore()+ " "+movie.getPrice());
        }else {
            System.out.println("没有此电影！");
        }
    }
    public Movie queryMovieByName(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    private void removeMovie() {
        System.out.println("=======下架电影=======");
        System.out.println("请输入电影名称：");
        String name = sc.next();
        Movie movie = queryMovieByName(name);
        if (movie != null) {
            movies.remove(movie);
        }else {
            System.out.println("没有此电影！");
        }
        System.out.println("下架成功！");
        
    }

    private void addMovie() {
        System.out.println("=======上架电影=======");
        Movie movie = new Movie();
        System.out.println("请输入电影名称：");
        movie.setName(sc.next());
        System.out.println("请输入电影评分：");
        movie.setScore(sc.nextDouble());
        System.out.println("请输入电影主演：");
        movie.setActor(sc.next());
        System.out.println("请输入电影价格：");
        movie.setPrice(sc.nextDouble());
        movies.add(movie);
        System.out.println("上架成功！");
    }
}
