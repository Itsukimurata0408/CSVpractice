import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CSVFileWrite {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		 //Calendarクラスのオブジェクトを生成する
        Calendar cl = Calendar.getInstance();

        //SimpleDateFormatクラスでフォーマットパターンを設定する
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.format(cl.getTime()));

        //date型をString型に変更
        String date = String.valueOf(sdf.format(cl.getTime()));
        //dateを/で区切る
        String[] ymd = date.split("/", 0);
        String strymd = ymd[0]+ymd[1]+ymd[2];

        //新規でファイルを作成
		File newfile = new File("src/csv/新人_"+strymd+".csv");

	    try{
	      if (newfile.createNewFile()){
	        System.out.println("ファイルの作成に成功しました");
	      }else{
	        System.out.println("ファイルは既に存在します");
	      }
	    }catch(IOException e){
	      System.out.println(e);
	    }



		try {
			//出力先を作成する
			FileWriter fw = new FileWriter("src/csv/新人_"+strymd+".csv", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			//項目を記載
			String[] data = {"名前","性別","出身地"};

			for(int i = 0;i < 3;i++) {
				pw.print(data[i]);
				if(i < 2) {
					pw.print(",");
				}

			}
			pw.println();

			//内容を指定する
			pw.print("村田樹");
			pw.print(",");
			pw.print("男");
			pw.print(",");
			pw.println("埼玉県");


			pw.print("佐藤優");
			pw.print(",");
			pw.print("女");
			pw.print(",");
			pw.println("宮城県");


			pw.print("山内宇史");
			pw.print(",");
			pw.print("男");
			pw.print(",");
			pw.println("大阪府");


			pw.print("朝比奈レナ");
			pw.print(",");
			pw.print("女");
			pw.print(",");
			pw.println("愛知県");

			//ファイルに書き出す
			pw.close();

			//終了メッセージを画面に出力する
			System.out.println("書き込みが完了しました。");

		} catch (IOException ex) {
			//例外時処理
			ex.printStackTrace();
		}
	}

}
