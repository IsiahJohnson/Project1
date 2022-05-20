import {createSlice, createAsyncThunk} from  "@reduxjs/toolkit";
import axios from "axios";
import {IReimbursement} from "../Interfaces/IReimbursement";


interface ReimbursementSliceState{
    loading: boolean,
    error: boolean,
    reimbursements?: IReimbursement[]
}

const initialReimbursementState: ReimbursementSliceState = {
    loading: false,
    error: false
};


export const getReimbursements = createAsyncThunk(
    "reimbursements/get",
    async (id:number,thunkAPI) => {
        try{
            axios.defaults.withCredentials = true;
            const res = await axios.get("http://localhost:8000/reimbursement/$(id)");
  
            return res.data;
        } catch (e){
            console.log(e);
        }
    }
);

export const createReimbursement = createAsyncThunk(
    "reimbursements/create",
    async (newReimbursement:IReimbursement, thunkAPI) => {
        try{
            axios.defaults.withCredentials = true;
            const res = await axios.post("http://localhost:8000/reimbursement/", newReimbursement);

            return newReimbursement;
        } catch (e){
            console.log(e);
        }
    }
)

export const getPendingReimbursements = createAsyncThunk(
    'reimbursements/get/pending',
    async (thunkAPI) => {
        try{
            const res = await axios.get(`http://localhost:8000/reimbursement/pending`);

            return res.data;
        } catch(error){
            console.log(error);
        }
    }
);

export const getResolvedReimbursements = createAsyncThunk(
    'reimbursements/get/resolved',
    async (thunkAPI) => {
        try{
            const res = await axios.get(`http://localhost:8000/reimbursement/resolved`);

            return res.data;
        } catch(error){
            console.log(error);
        }
    }
);

export const updateReimbursement = createAsyncThunk(
    'reimbursements/update',
    async (uReimbursement:IReimbursement, thunkAPI) => {
        try{
            const res = await axios.put(`http://localhost:8000/reimbursements/update/${uReimbursement.reimbursementId}`, {
                amount: uReimbursement.amount,
                resolvedDate: uReimbursement.resolvedDate,
                description: uReimbursement.description,
                reimbursementResolver: uReimbursement.reimbursementResolver,
                reimbursementStatus: uReimbursement.reimbursementStatus
              })
              
            }catch(error){
                console.log(error);
        }
    }
);

export const ReimbursementSlice = createSlice({
    name: "reimbursement",
    initialState: initialReimbursementState,
    reducers: {
        clearReimbursements : (state) => {
            state.reimbursements = undefined;
        }
    },
    extraReducers: (builder) => {
        
        
            builder.addCase(getReimbursements.pending, (state, action)=> {
                state.loading = true;
            });
    
            builder.addCase(getReimbursements.fulfilled, (state, action) => {
                state.reimbursements = action.payload;
                state.loading = false;
                state.error = false;
            });
    
            builder.addCase(getReimbursements.rejected, (state, action) => {
                state.error = true;
                state.loading = false;
            });
            builder.addCase(getPendingReimbursements.pending, (state, action)=> {
                state.loading = true;
            });
    
            builder.addCase(getPendingReimbursements.fulfilled, (state, action) => {
                state.reimbursements = action.payload;
                state.loading = false;
                state.error = false;
            });
    
            builder.addCase(getPendingReimbursements.rejected, (state, action) => {
                state.error = true;
                state.loading = false;
            });
            builder.addCase(getResolvedReimbursements.pending, (state, action)=> {
                state.loading = true;
            });
    
            builder.addCase(getResolvedReimbursements.fulfilled, (state, action) => {
                state.reimbursements = action.payload;
                state.loading = false;
                state.error = false;
            });
    
            builder.addCase(getResolvedReimbursements.rejected, (state, action) => {
                state.error = true;
                state.loading = false;
            });
            builder.addCase(createReimbursement.fulfilled, (state, action) => {
                if(state.reimbursements && action.payload){
                    state.reimbursements = [action.payload, ...state.reimbursements];
                }
            });
            builder.addCase(updateReimbursement.fulfilled, (state, action) => {
                state.loading = false;
                state.error = false;
            });
            builder.addCase(updateReimbursement.rejected, (state, action) => {
                state.error = true;
                state.loading = false;
            });


        }
    });

export const {clearReimbursements} = ReimbursementSlice.actions;

export default ReimbursementSlice.reducer;
