package vn.edu.ntu.nguyendinhhoanglan.ontap_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import vn.edu.ntu.nguyendinhhoanglan.controller.INgoaiTeController;
import vn.edu.ntu.nguyendinhhoanglan.model.NgoaiTe;

public class SecondFragment extends Fragment {
    List<NgoaiTe> list;
    NgoaiTeAdapter adapter;
    RecyclerView rvNT;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addViews(v);
        return v;
    }

    private void addViews(View v) {
        rvNT = v.findViewById(R.id.rvNT);
        rvNT.setLayoutManager(new LinearLayoutManager(getContext()));
        list = ((INgoaiTeController)getActivity().getApplication()).getAll();
        adapter = new NgoaiTeAdapter(list);
        rvNT.setAdapter(adapter);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private class NgoaiTeViewHolder extends RecyclerView.ViewHolder{
        TextView txtDate, txtType, txtBuy, txtSell;
        ImageView imvAddToCart;
        NgoaiTe p;
        private NgoaiTeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = this.itemView.findViewById(R.id.txtDate);
            txtType = this.itemView.findViewById(R.id.txtType);
            txtBuy = this.itemView.findViewById(R.id.txtBuy);
            txtSell = this.itemView.findViewById(R.id.txtSell);
        }

        private void bind(NgoaiTe p){
            this.p = p;
            txtDate.setText(p.getDate());
            txtType.setText(p.getType());
            txtBuy.setText(String.format(Locale.ENGLISH, "Mua vào: %d", p.getBuy()));
            txtSell.setText(String.format(Locale.ENGLISH, "Bán ra: %d", p.getSell()));
        }

//        private void updateCart(){
//            SecondFragment f = (SecondFragment) getFragmentManager().findFragmentById(R.id.SecondFragment);
//            f.show
//        }
    }

    private class NgoaiTeAdapter extends RecyclerView.Adapter<NgoaiTeViewHolder>{
        List<NgoaiTe> ngoaiTeList;

        private NgoaiTeAdapter(List<NgoaiTe> ngoaiTeList) {
            this.ngoaiTeList = ngoaiTeList;
        }

        @NonNull
        @Override
        public NgoaiTeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.info, parent, false);
            // view: res/layout/product.xml
            return new NgoaiTeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NgoaiTeViewHolder holder, int position) {
            holder.bind(ngoaiTeList.get(position));
        }

        @Override
        public int getItemCount() {
            return ngoaiTeList.size();
        }
    }
}