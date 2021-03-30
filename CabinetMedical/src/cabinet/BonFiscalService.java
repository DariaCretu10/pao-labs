package cabinet;

public class BonFiscalService {
    public static void afisareBonData(BonFiscal[] bonuri, String data)
    {
        for (BonFiscal bon : bonuri)
        {
            if ( bon.getData().equals(data))
            System.out.println(bon.toString());
        }
    }

    public static BonFiscal[] adaugareBon(BonFiscal[] bonuri, BonFiscal bonNou)
    {
        BonFiscal[] bonuriNoi = new BonFiscal[bonuri.length+1];
        for(int i = 0; i<bonuri.length; i++)
            bonuriNoi[i] = bonuri[i];
        bonuriNoi[bonuri.length] = bonNou;
        return bonuriNoi;
    }

    public static void afisareBon(BonFiscal[] bonuri)
    {
        for (BonFiscal bon : bonuri)
        {
            System.out.println(bon.toString());
        }
    }

    public static BonFiscal[] stergeBon(BonFiscal[] bonuri, BonFiscal bonSters)
    {
        BonFiscal[] bonuriNou = new BonFiscal[bonuri.length-1];
        for ( int i=0; i<bonuriNou.length; i++)
        {
            if ( bonuri[i].equals(bonSters))
            {
                for (int j=i; j<bonuriNou.length; j++)
                {
                    bonuri[j] = bonuri[j+1];
                }
            }

            bonuriNou[i] = bonuri[i];
        }
        return bonuriNou;
    }
}
