package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/3.
 */

public class TermsBean {
    private int code;
    private String message;
    private ArrayList<Term> terms;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public ArrayList<Term> getTerms() {
        return this.terms;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setTerms(ArrayList<Term> paramArrayList) {
        this.terms = paramArrayList;
    }

    public static class Term implements Parcelable {
        private String name;
        private String term_id;

        protected Term(Parcel in) {
            name = in.readString();
            term_id = in.readString();
        }

        public static final Creator<Term> CREATOR = new Creator<Term>() {
            @Override
            public Term createFromParcel(Parcel in) {
                return new Term(in);
            }

            @Override
            public Term[] newArray(int size) {
                return new Term[size];
            }
        };

        public String getName() {
            return this.name;
        }

        public String getTerm_id() {
            return this.term_id;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setTerm_id(String paramString) {
            this.term_id = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(term_id);
        }
    }
}
