package com.example.ecommerceapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.adapter.BannerAdapter;
import com.example.ecommerceapp.api.APIClient;
import com.example.ecommerceapp.databinding.FragmentHomeBinding;
import com.example.ecommerceapp.model.homeBanner.BannerItem;
import com.example.ecommerceapp.model.homeBanner.BannerModelResponse;

import org.imaginativeworld.whynotimagecarousel.model.CarouselGravity;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    BannerAdapter bannerAdapter;
    List<BannerItem> banerList= new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setUpRecyclerView();
        callBannerApi();

        return  view;

    }

    private void callBannerApi() {
        Call<BannerModelResponse> call = APIClient.getInstance().getApi().getBanner();
        call.enqueue(new Callback<BannerModelResponse>() {
            @Override
            public void onResponse(Call<BannerModelResponse> call, Response<BannerModelResponse> response) {

                if (response.isSuccessful()){
                    BannerModelResponse bannerModelResponse = response.body();
                    binding.carousel.setCarouselGravity(CarouselGravity.CENTER);
                    for (int i= 0; i<bannerModelResponse.getBanner().size();i++){
                        binding.carousel.addData(new CarouselItem(bannerModelResponse.getBanner().get(i).getBannerImage()));
                    }


                }else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<BannerModelResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "BannerApiFailed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void setUpRecyclerView() {
        bannerAdapter = new BannerAdapter(getActivity() , banerList);
    }
}