package com.example.seva_knpc.ui.Faqs;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.example.seva_knpc.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FaqFragment extends Fragment {

    ExpandableListView expandableListView;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;


    Activity Faq;

    public FaqFragment() {
        // Required empty public constructor
    }


    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Faq = getActivity();
        return inflater.inflate(R.layout.fragment_faq, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();


        expandableListView = Faq.findViewById(R.id.exp_lst_about);

        initialze();

        ExpandableListViewAdaptor viewAdaptor = new ExpandableListViewAdaptor(Faq,listDataHeader,listHashMap);
        expandableListView.setAdapter(viewAdaptor);

    }

    public void initialze()
    {
            listDataHeader = new ArrayList<>();
            listHashMap = new HashMap<>();

        listDataHeader.add("How many types of scholarships do students get?");
        listDataHeader.add("Scholarship Application Process");
        listDataHeader.add("To which university is the college affiliated?");
        listDataHeader.add("What is the process to obtain TC certificate?");
        listDataHeader.add("What is UFM?");
        listDataHeader.add("How many types of fees do students have to pay?");
        listDataHeader.add("What is the process of paying different types of fees?");
        listDataHeader.add("What is the procedure for admission to second year?");
        listDataHeader.add("What is the procedure for admission to third year?");
        listDataHeader.add("Where to get AICTE based syllabus?");
        listDataHeader.add("How to fill exam form?");



//        List<String> ans1 = new ArrayList<>();
//        ans1.add("TED Conferences LLC (Technology, Entertainment, Design) is an American media organization that posts talks online for free distribution under the slogan \"ideas worth spreading\". TED was conceived by Richard Saul Wurman in February 1984 as a conference; it has been held annually since 1990. The main TED conference is held annually in Vancouver, British Columbia, Canada at the Vancouver Convention Centre. Prior to 2014, the conference was held in Long Beach, California, United States.TED events are also held throughout North America and in Europe, Asia, and Africa, offering live streaming of the talks");
//        listHashMap.put(listDataHeader.get(0),ans1);
//        List<String> ans2 = new ArrayList<>();
//        ans2.add("The difference between TED and TEDx events are that the former takes more of a global approach while the latter typically focuses on a local community that concentrates on local voices. “Officially, the ‘x’ in TEDx stands for independently organized TED event – but it’s more of a TED multiplied.");
//
//        List<String> ans3 = new ArrayList<>();
//        ans3.add("TEDxIIITA builds a TED like experience at Indian Institute of Information Technology, Allahabad in order to engage the students, leading professors and researchers, area leaders and visionaries in thoughtful discussions. Our goal is to bring together bright minds to give talks that are idea focused, and on a wide range of subjects, to foster learning, inspiration and wonder, and provoke conversations that matter");
//
//        List<String> ans4 = new ArrayList<>();
//        ans4.add("Yogesh Sasini");
//        ans4.add("Mallakhamb Artist India");
//        ans4.add("Lt. Col. Pankajashan K");
//        ans4.add("Neeraj Narayanan");
//        ans4.add("Yugm");
//
        List<String> ans0= new ArrayList<>();
        ans0.add("Chief Minister Medhavi Vidyarthi Yojana\n" +
                "Chief Minister Public Welfare (Education Promotion) Scheme\n" +
                "Post Matric Scholarship (SC, ST, OBC)\n" +
                "And so on.\n" +
                "\n" +
                "मुख्यमंत्री मेधावी विद्यार्थी योजना\n" +
                "मुख्यमंत्री जनकल्याण(शिक्षा प्रोत्साहन)योजना \n" +
                "पोस्ट मेट्रिक छात्रवृत्ति ( एससी, एसटी, ओबीसी)\n" +
                "इत्यादि.");
        List<String> ans1 = new ArrayList<>();
        ans1.add("www.tribal.mp.gov.in/MPTAAS\n" +
                "Visit the website. New students create a new account. Login. Fill the complete form. Print the form. Attach all the documents. Submit it to your department..\n" +
                "\n" +
                "वेबसाइट पर जाएं।नए विद्यार्थी नया अकाउंट बनाएं। लॉगिन करें। पूर्ण फॉर्म भरें। फॉर्म प्रिंट करें। सभी डॉक्यूमेंट्स संलग्न करें। अपने विभाग में जमा करें।.");
        List<String> ans2= new ArrayList<>();
        ans2.add("The college is affiliated to Rajiv Gandhi University, Bhopal and has courses approved by AICTE..\n" +
                "\n" +
                "कॉलेज की संबद्धता राजीव गांधी विश्वविद्यालय भोपाल से है तथा एआईसीटीई द्वारा मान्यता प्राप्त पाठ्यक्रम हैं।.");
        List<String> ans3= new ArrayList<>();
        ans3.add("For TC certificate, download the TC form from the college website and complete the form.\n" +
                "Get NOC from various departments. Deposit the TC fee through SBI collect. Attach the desired documents to the form. Finally submit the form to the academic department. After one week, present yourself and get TC..\n" +
                "\n" +
                "टी सी प्रमाण पत्र हेतु टी सी का फॉर्म कॉलेज वेबसाइट से डाउनलोड करें तथा फॉर्म को पूर्ण करें।\n" +
                "विभिन्न विभागों से NOC करवाएं। टी सी का शुल्क SBI collect से जमा करे। फॉर्म में वांछित डॉक्यूमेंट्स संलग्न करें। अंत में फॉर्म शैक्षणिक विभाग में जमा करें। एक सप्ताह उपरांत स्वयं उपस्थित होकर टी सी प्राप्त करें।.");
        List<String> ans4= new ArrayList<>();
        ans4.add("Cheating during the examination conducted by the university constitutes a case of UFM i.e. Unfair Means. The punishment may include banning one paper or the entire semester or entire year from the examination..\n" +
                "\n" +
                "विश्वविद्यालय द्वारा आयोजित परीक्षा के दौरान नकल करने पर UFM अर्थात Unfair means का केस बनता है। इसमें दंड के रूप में एक पेपर या पूरा सेमेस्टर या पूरे वर्ष की परीक्षा से प्रतिबंधित किया जा सकता है।.");
        List<String> ans5= new ArrayList<>();
        ans5.add("Admission Fee\n" +
                "Enrollment Fee\n" +
                "Examination Fee.\n" +
                "TC Fee.\n" +
                "\n" +
                "प्रवेश शुल्क\n" +
                "एनरोलमेंट शुल्क\n" +
                "परीक्षा शुल्क\n"+
                "टी सी  शुल्क")
        ;
        List<String> ans6= new ArrayList<>();
        ans6.add(
                "* To pay various types of fees, visit www.onlinesbi.com website.\n" +
                "* Click on the tab of SBI collect.\n" +
                "* Select Educational institution.\n" +
                "* Select the Principal kalaniketan polytechnic college.\n" +
                "* Select the appropriate form.\n" +
                "* Make online payment.\n" +
                "* Print the receipt..\n" +
                "\n" +
                "* विभिन्न प्रकार शुल्क भरने हेतु www.onlinesbi.com वेबसाइट पर जाएं। \n" +
                "* Sbi collect के टैब पर क्लिक करें।\n" +
                "* Educational institution का चयन करें। \n" +
                "* The Principal kalaniketan polytechnic college का चयन करें। \n" +
                "* उपयुक्त फॉर्म का चयन करें।\n" +
                "* ऑनलाइन पेमेंट करें।\n" +
                "* रसीद प्रिंट करें।.");
        List<String> ans7= new ArrayList<>();
        ans7.add("To get admission in second year, the student should not have failed in 6 or more subjects in the first year..\n" +
                "\n" +
                "द्वितीय वर्ष में प्रवेश हेतु छात्र को प्रथम वर्ष में  6 या अधिक विषयों में फेल नहीं होना चाहिए।.");
        List<String> ans8= new ArrayList<>();
        ans8.add(
                "* Must have passed all subjects of first year and grade should be 5.0 or above.\n" +
                "\n" +
                "* To get admission in third year, the student should not have failed in 6 or more subjects in the second year..\n" +
                "\n" +
                "* प्रथम वर्ष के सभी विषय उत्तीर्ण होना चाहिए तथा ग्रेड  5.0 या अधिक होना चाहिए।\n" +
                "\n" +
                "* द्वितीय वर्ष में 6 या अधिक विषयों में फेल नहीं होना चाहिए।.");

        List<String> ans9= new ArrayList<>();
        ans9.add(
                "* Visit RGPV Website\n" +
                "* Select AICTE based OCBC 2023 curriculum\n" +
                "* and download a Syllabus\n"+
                "\n"+
                "* आरजीपीवी वेबसाइट पर जाएं\n" +
                "* AICTE आधारित OCBC 2023 पाठ्यक्रम का चयन करें\n" +
                "* और पाठ्यक्रम डाउनलोड करें");



        List<String> ans10= new ArrayList<>();
        ans10.add(
                "* Collect all your documents and submit them to the department\n" +
                "* After verification of documents visit RGPV website and do your student login\n"+
                "* After student login select Student Services\n"+
                "* After selecting Student Services, select File Exam Form\n"+
                "* After completing this entire process pay the examination form fee\n"+
                "\n"+
                "* अपने सभी दस्तावेज एकत्रित कर विभाग में जमा करे\n"+
                "* दस्तावेजों के सत्यापन के बाद RGPV की वेबसाइट पर जाएं और अपना छात्र लॉगिन करें\n"+
                "* छात्र लॉगिन के बाद छात्र सेवाएँ चयन करे\n"+
                "* छात्र सेवाएँ का चयन करने के बाद Fill Exam फॉर्म का चयन करें\n"+
                "* इस पूरी प्रक्रिया को पूरा करने के बाद परीक्षा फॉर्म शुल्क का भुगतान करें\n"
        );


        listHashMap.put(listDataHeader.get(0),ans0);
        listHashMap.put(listDataHeader.get(1),ans1);
        listHashMap.put(listDataHeader.get(2),ans2);
        listHashMap.put(listDataHeader.get(3),ans3);
        listHashMap.put(listDataHeader.get(4),ans4);
        listHashMap.put(listDataHeader.get(5),ans5);
        listHashMap.put(listDataHeader.get(6),ans6);
        listHashMap.put(listDataHeader.get(7),ans7);
        listHashMap.put(listDataHeader.get(8),ans8);
        listHashMap.put(listDataHeader.get(9),ans9);
        listHashMap.put(listDataHeader.get(10),ans10);


    }

}