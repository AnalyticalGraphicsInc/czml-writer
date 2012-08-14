using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.IO;
using System.Windows.Forms;
using System.Data;

namespace LoadDBF
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
		private System.Windows.Forms.DataGrid grdDBF;
		private System.Windows.Forms.Button btnLoadDBF;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if (components != null) 
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.grdDBF = new System.Windows.Forms.DataGrid();
			this.btnLoadDBF = new System.Windows.Forms.Button();
			((System.ComponentModel.ISupportInitialize)(this.grdDBF)).BeginInit();
			this.SuspendLayout();
			// 
			// grdDBF
			// 
			this.grdDBF.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.grdDBF.DataMember = "";
			this.grdDBF.HeaderForeColor = System.Drawing.SystemColors.ControlText;
			this.grdDBF.Location = new System.Drawing.Point(16, 88);
			this.grdDBF.Name = "grdDBF";
			this.grdDBF.Size = new System.Drawing.Size(864, 464);
			this.grdDBF.TabIndex = 0;
			// 
			// btnLoadDBF
			// 
			this.btnLoadDBF.Location = new System.Drawing.Point(24, 24);
			this.btnLoadDBF.Name = "btnLoadDBF";
			this.btnLoadDBF.Size = new System.Drawing.Size(120, 40);
			this.btnLoadDBF.TabIndex = 1;
			this.btnLoadDBF.Text = "Load DBF";
			this.btnLoadDBF.Click += new System.EventHandler(this.btnLoadDBF_Click);
			// 
			// Form1
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(896, 566);
			this.Controls.Add(this.btnLoadDBF);
			this.Controls.Add(this.grdDBF);
			this.Name = "Form1";
			this.Text = "Load DBF";
			((System.ComponentModel.ISupportInitialize)(this.grdDBF)).EndInit();
			this.ResumeLayout(false);

		}
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new Form1());
		}

		private void btnLoadDBF_Click(object sender, System.EventArgs e)
		{
			try
			{
				OpenFileDialog ofd = new OpenFileDialog();
				ofd.Filter = "dBASE files (*.dbf)|*.dbf";
				ofd.ShowDialog();

				if (ofd.FileName.Length > 0)
				{
					DataTable dt = ParseDBF.ReadDBF(ofd.FileName);
					grdDBF.DataSource = dt;
				}
			}
			catch (Exception ex)
			{
				MessageBox.Show(this, ex.Message + "\r\r" + ex.StackTrace, "Exception!", MessageBoxButtons.OK, MessageBoxIcon.Error);
			}
		}
	}
}
