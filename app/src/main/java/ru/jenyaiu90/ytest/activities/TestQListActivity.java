package ru.jenyaiu90.ytest.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

import ru.jenyaiu90.ytest.R;
import ru.jenyaiu90.ytest.adapters.QuestionAdapter;
import ru.jenyaiu90.ytest.data.Task;
import ru.jenyaiu90.ytest.data.TaskLong;
import ru.jenyaiu90.ytest.data.TaskMany;
import ru.jenyaiu90.ytest.data.TaskOne;
import ru.jenyaiu90.ytest.data.TaskShort;
import ru.jenyaiu90.ytest.data.Test;
import ru.jenyaiu90.ytest.data.Util;

public class TestQListActivity extends Activity
{
	protected Test test;
	protected ArrayList<Task> alist;

	ListView questionsLV;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_q_list);

		questionsLV = (ListView)findViewById(R.id.questionsLV);

		test = Util.getTestAsExtra(getIntent());
		alist = test.getTasks();

		loadTest();
	}

	protected void loadTest()
	{
		String tasks[][] = new String[test.size()][2];

		for (int i = 0; i < alist.size(); i++)
		{
			String type;
			switch (alist.get(i).getType())
			{
				case ONE:
					type = getResources().getString(R.string.one_q);
					break;
				case MANY:
					type = getResources().getString(R.string.many_q);
					break;
				case SHORT:
					type = getResources().getString(R.string.short_q);
					break;
				case LONG:
					type = getResources().getString(R.string.long_q);
					break;
				default:
					type = "This value is impossible!";
			}
			tasks[i][0] = alist.get(i).getText();
			tasks[i][1] = type;
		}
		QuestionAdapter adapter = new QuestionAdapter(TestQListActivity.this, tasks);
		questionsLV.setAdapter(adapter);
	}

	public void create(View view)
	{
		
	}
}
