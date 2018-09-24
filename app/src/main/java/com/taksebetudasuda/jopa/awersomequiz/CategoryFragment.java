package com.taksebetudasuda.jopa.awersomequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CategoryFragment extends Fragment implements ItemCliclListener {

    View myFragment;

    RecyclerView listCategory;
    private MyAdapter adapter;

    ArrayList<Category> categoryArrayList;

    public static CategoryFragment newInstance(){
        CategoryFragment categoryFragment = new CategoryFragment();
        return categoryFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_category, container,false);

        categoryArrayList = QuestionLab.get(getActivity()).getAllCategories();

        listCategory = myFragment.findViewById(R.id.listCategory);
        listCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        listCategory.setHasFixedSize(true);

//        layoutManager = new LinearLayoutManager(container.getContext());
//        listCategory.setLayoutManager(layoutManager);



        adapter = new MyAdapter(getActivity(),categoryArrayList);
        adapter.setItemCliclListener(this);
        listCategory.setAdapter(adapter);

        return myFragment;
    }

    @Override
    public void onClick(View view, int position) {
        String difficulty = adapter.getItem(position).getCategoty();
        startQuiz(difficulty);
//        Toast.makeText(getActivity(),  adapter.getItem(position).getCategoty(), Toast.LENGTH_SHORT).show();
    }

    private void startQuiz(String difficulty) {
        Intent intent = QuizActivity.newIntent(getActivity(),difficulty);
        startActivity(intent);
//        Intent intent = new Intent(getActivity(), QuizActivity.class);
//        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
//        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    public void onResume() {
        super.onResume();

        QuestionLab crimeLab = QuestionLab.get(getActivity());
        ArrayList<Category> crimes = crimeLab.getAllCategories();

        if (adapter == null) {
            adapter = new MyAdapter(getActivity(),crimes);
            listCategory.setAdapter(adapter);
        } else {
            adapter.setCategoryList(crimes);
            adapter.notifyDataSetChanged();
        }
    }
    //    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CODE_QUIZ) {
//            if (resultCode == RESULT_OK) {
//                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
//                Toast.makeText(getActivity(), score, Toast.LENGTH_SHORT).show();
////                if (score > highscore) {
////                    updateHighscore(score);
////                }
//            }
//        }
//    }
}