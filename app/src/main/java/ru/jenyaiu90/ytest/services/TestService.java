package ru.jenyaiu90.ytest.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.jenyaiu90.ytest.entity.AnswerEntity;
import ru.jenyaiu90.ytest.entity.ServerAnswerEntity;
import ru.jenyaiu90.ytest.entity.TaskEntity;
import ru.jenyaiu90.ytest.entity.TestEntity;
import ru.jenyaiu90.ytest.entity.UserEntity;

public interface TestService
{
	@POST("/test/create")
	Call<TestEntity> createTest(@Query("test_name") String test_name, @Query("subject") String subject, @Body List<TaskEntity> tasks, @Query("login") String user, @Query("password") String password);

	@GET("/test/get")
	Call<TestEntity> getTest(@Query("test_id") int test_id);

	@POST("/test/answer")
	Call<ServerAnswerEntity> setAnswer(@Query("answers") String[] answers, @Query("test_id") int test_id, @Query("login") String login, @Query("password") String password);

	@GET("test/get_result")
	Call<List<AnswerEntity>> getAnswers(@Query("login") String login, @Query("test_id") int test_id);

	@GET("/test/get_for_user")
	Call<List<TestEntity>> getTestsForUser(@Query("login") String login);

	@GET("/test/get_of_user")
	Call<List<TestEntity>> getTestsOfUser(@Query("login") String login);

	@GET("/test/get_author")
	Call<UserEntity> getAuthorOfTest(@Query("test_id") int test_id);

	@GET("/test/get_is_solved")
	Call<ServerAnswerEntity> getIsSolved(@Query("login") String login, @Query("test_id") int test_id);
}
