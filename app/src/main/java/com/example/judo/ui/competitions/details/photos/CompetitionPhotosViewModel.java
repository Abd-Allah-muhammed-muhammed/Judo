package com.example.judo.ui.competitions.details.photos;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.judo.model.photos.PhotosModel;

import java.util.ArrayList;
import java.util.List;

public class CompetitionPhotosViewModel extends ViewModel {


   private MutableLiveData<List<PhotosModel>> data  = new MutableLiveData<>();


   public MutableLiveData<List<PhotosModel>> getData(){


       List<PhotosModel> photosModels = new ArrayList<>();

       photosModels.add(new PhotosModel("https://cdn.pixabay.com/photo/2017/11/13/23/33/landscape-2947094_960_720.jpg"));
       photosModels.add(new PhotosModel("https://wallpaperaccess.com/full/124582.jpg"));
       photosModels.add(new PhotosModel("https://www.robin-noorda.com/uploads/1/6/8/3/16830688/3347022_orig.jpg"));
          photosModels.add(new PhotosModel("https://cdn.pixabay.com/photo/2017/11/13/23/33/landscape-2947094_960_720.jpg"));
       photosModels.add(new PhotosModel("https://wallpaperaccess.com/full/124582.jpg"));
       photosModels.add(new PhotosModel("https://www.robin-noorda.com/uploads/1/6/8/3/16830688/3347022_orig.jpg"));
          photosModels.add(new PhotosModel("https://cdn.pixabay.com/photo/2017/11/13/23/33/landscape-2947094_960_720.jpg"));
       photosModels.add(new PhotosModel("https://wallpaperaccess.com/full/124582.jpg"));
       photosModels.add(new PhotosModel("https://www.robin-noorda.com/uploads/1/6/8/3/16830688/3347022_orig.jpg"));
          photosModels.add(new PhotosModel("https://cdn.pixabay.com/photo/2017/11/13/23/33/landscape-2947094_960_720.jpg"));
       photosModels.add(new PhotosModel("https://wallpaperaccess.com/full/124582.jpg"));
       photosModels.add(new PhotosModel("https://www.robin-noorda.com/uploads/1/6/8/3/16830688/3347022_orig.jpg"));


       data.setValue(photosModels);

       return data;
   }
}
