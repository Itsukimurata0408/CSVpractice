import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CSVFileRead {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//Fileのソート
		File dir = new File("src/csv/");
		File[] file = dir.listFiles();
		Arrays.sort(file, new Comparator<File>() {
			@Override
			public int compare(File file1, File file2) {
				return file1.lastModified() <= file2.lastModified() ? 1 : -1;
			}
		});


		System.out.println("表示ファイル："+file[0].getName());





		//以下CSV出力
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		try {


			//更新日時が最新のファイル名を指定する
			fi = new FileInputStream("src/csv/"+file[0].getName());
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			//行の読み込み
			String line;
			int i = 0;

			//列名の配列
			String[] rec = null;

			//1行ずつ読み込みを行う
			while ((line = br.readLine()) != null) {

				//列名の読み込み
				if (i == 0) {
					//カンマで分割した内容を配列に格納する
					rec = line.split(",");

				} else {
					System.out.println("-------------------------------");

					//データ件数を表示
					System.out.println("データ" + i + "件目");

					//カンマで分割した内容を配列に格納する
					String[] data = line.split(",");

					//配列の中身を上から表示する。配列の要素数分繰り返す
					int j = 0;
					for (String column : rec) {
						System.out.println(column + ":" + data[j]);
						j++;
					}
				}
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//closeを必ず行う
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


