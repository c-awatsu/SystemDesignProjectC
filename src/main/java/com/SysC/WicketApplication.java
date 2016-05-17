package com.SysC;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.SysC.signIn.AbstractSignInPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see com.SysC.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return AbstractSignInPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init(){
		super.init();

		// サーバ・クライアント間のリクエスト・レスポンスの文字エンコード
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		// Wicketに取り込まれるHTMLファイルのエンコード
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		initGuiice();
		mountResource();
	}

	/**
	 * Page や Resource をマウントする.
	 * URLの最後尾を好きな名前?で表示できる
	 */
	public void mountResource() {

	}

	/**
	 * Google Guiceを初期化する.
	 */
	private void initGuiice() {
		getComponentInstantiationListeners().add(new GuiceComponentInjector(this));
	}

}
