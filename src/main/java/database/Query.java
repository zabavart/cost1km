package database;

public class Query {
  public static String car_mark =
      "select id_car_mark, " +
      "       name " +
      "  from car_mark;";

  public static String car_model =
      "select id_car_model, " +
      "       name " +
      "  from car_model;";

  public static String car_model_by_id_car_model =
          "select id_car_model, " +
          "       name " +
          "  from car_model " +
          " where id_car_mark = ?";
}
