import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) {
            return res;
        }

        res.add(new ArrayList<>());
        res.get(0).add(1);

        // 从第二行开始生成
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = res.get(i - 1);
            // 每行第一个元素为1
            row.add(1);
            // 从上一行计算下一行元素数据
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);

            res.add(row);
        }

        return res;
    }


    public static void main(String[] args) {
        杨辉三角 main = new 杨辉三角();
        main.generate(4);
    }
}
