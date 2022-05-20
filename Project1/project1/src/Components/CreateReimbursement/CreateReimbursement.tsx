import React, {useState, useEffect} from 'react';

import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, RootState } from '../../Store';
import { createReimbursement } from '../../Slices/ReimbursementSlice';

import pic from '../../deafultpic.jpg';
import { IReimbursement } from '../../Interfaces/IReimbursement';

//import './CreateReimbursement.css';

export const CreateReimbursement: React.FC = () => {

    const [description, setContent] = useState<string>("");
    const [amount, setAmount] = useState("");
    const [value, setValue] = useState("");

    const currentUser = useSelector((state:RootState)=> state.user.user);
    const dispatch:AppDispatch = useDispatch();

    const handleChange = (event:React.ChangeEvent<HTMLTextAreaElement>) => {
            if(event.target.name === "description"){
                setContent(event.target.value);
            }
            else {
                setAmount(event.target.value);
            }
        
    }

    const handleOption = (b: { target: { value: React.SetStateAction<string>; }; }) => {
        setValue(b.target.value);
      };

    const handleReimbursement = () => {

        let d = new Date();
        let a = new Date(0);
        if(currentUser){
            let reimbursement:IReimbursement = {
                reimbursementId: 0,
                description,
                amount: parseInt(amount),
                submittedDate: d,
                resolvedDate: a,
                reimbursementAuthor: 0,
                reimbursementResolver: 0,
                reimbursementStatus: 0,
                reimbursementType: parseInt(value)
            }

            dispatch(createReimbursement(reimbursement));
        }
    }

    useEffect(() => {
        console.log(description);
    }, [description])

    return(
        <div className="create-container">
            <div className="content-container">
                <img className="create-profile-pic" src={pic} />
                <textarea className="description" onChange={handleChange} placeholder="What for?" maxLength={256}></textarea>
                <textarea className="amount" onChange={handleChange} placeholder="Enter amount" maxLength={256}></textarea>
                <label>
                    What type of reimbursement?
                    <select value={value} onChange={handleOption}>
                    <option value="1">Lodging</option>
                    <option value="2">Travel</option>
                    <option value="3">Food</option>
                    <option value="4">Other</option>
                    </select>
                </label>
            </div>
            <button className="create-btn" onClick={handleReimbursement}>Create </button>
        </div>
    )

}